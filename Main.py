class Room: 
    
    def __init__(self, price, number):
        self.electric = 0
        self.water = 0

        self.room_price = price 
        self.number = number

        self.trash = 50 
        self.water_per_unit = 15 
        self.electric_per_unit = 7 
        self.internet = 0

    def calculate(self):
        if self.eletric_unit_thismonth < self.eletric_unit_lastmonth :
            raise ValueError('ERROR ROOM ELECTRIC '+ self.number)
        if self.water_unit_thismonth < self.water_unit_lastmonth :
            raise ValueError('ERROR ROOM WATER '+ self.number)
        eunit = (self.eletric_unit_thismonth - self.eletric_unit_lastmonth)
        wunit = (self.water_unit_thismonth - self.water_unit_lastmonth)
        
        if wunit < 6 :
            wunit = 6

        self.electric = eunit * self.electric_per_unit 
        self.water = wunit * self.water_per_unit

        total = self.electric + self.water + self.trash + self.internet + self.room_price

        return "น้ำ :  " + str(wunit) + "x15 = " + str(self.water) + " บาท\nไฟ :  " + str(eunit) + "x7 = " + str(self.electric) + " บาท\nค่าห้อง : " + str(self.room_price) + " บาท\nค่าขยะ : " + str(self.trash) + " บาท\nค่าเนต : " + str(self.internet) + " บาท\nสุทธิ : " + str(total) + " บาท\n\n\n"
    def setVar(self,eletric_unit_thismonth,water_unit_thismonth,eletric_unit_lastmonth,water_unit_lastmonth):
        self.eletric_unit_thismonth = eletric_unit_thismonth
        self.water_unit_thismonth = water_unit_thismonth
        self.eletric_unit_lastmonth = eletric_unit_lastmonth
        self.water_unit_lastmonth = water_unit_lastmonth

def readfile(filename):
    temp=[]
    f = open(filename, "r")
    for x in f:
        temp.append(int(x))
    f.close()
    return temp

from datetime import date

today = date.today()

room = []
room.append(Room(2200,'1')) # 1
room.append(Room(2100,'2')) # 2
room.append(Room(2200,'3')) # 3
room.append(Room(2200,'4')) # 4
room.append(Room(2000,'5')) # 5
room.append(Room(2200,'6')) # 6
room.append(Room(2200,'7')) # 7
room.append(Room(2200,'8')) # 8
room.append(Room(2000,'9')) # 9
room.append(Room(2000,'10')) # 10
room.append(Room(2200,'11')) # 11
room.append(Room(2000,'12')) # 12
room.append(Room(2000,'01')) # 01
room.append(Room(2000,'02')) # 02
room.append(Room(2200,'03')) # 03
room.append(Room(2400,'04')) # 04
room.append(Room(2200,'05')) # 05

wt = readfile("water_thismont.txt")
wl = readfile("water_lastmont.txt")
et = readfile("electric_thismont.txt")
el = readfile("electric_lastmont.txt")

s=""
for i in range(len(wt)):
    room[i].setVar( et[i],wt[i],el[i],wl[i]) 
    
    if i < 12:
        s = s + "Room [ " + str((i + 1)%13) + " ] || " + str(today) + " \n" + room[i].calculate()
    else :
        s = s + "Room [ 0" + str((i + 1)%12) + " ] || " + str(today) + " \n" + room[i].calculate()

# print(s)
f2 = open("Total.txt", "w" ,encoding='utf-8')
f2.write(s)
f2.close()
