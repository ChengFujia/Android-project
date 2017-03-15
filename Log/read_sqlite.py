#-*- coding:utf-8 -*-
import sqlite3
import binascii as ba
conn = sqlite3.connect("zidian_full.db")
cur = conn.cursor()

#cur.execute("""SELECT * FROM zi""")
cur.execute("""SELECT zhujie FROM zi WHERE _id = 12295""")
one = cur.fetchone()
#print one
string = ""
for row in one[0]:
	string += row

print "----------Original String-----------"
print string

print "----------Hex String----------------"
string_hex = string.encode('hex')
print string_hex

print "----------Ascii String--------------"
# 十六进制 =》 字符串
string_ascii = ba.a2b_hex(string_hex)
print string_ascii

"""
print "----------UTF-8 String--------------.decode('ascii').encode('UTF-8')"
temp = string_ascii.decode('UTF-8')
print temp.replace('0x','')
print "----------GBK String----------------"
print string_ascii.encode('GBK')
print "----------GBK2312 String------------"
print string_ascii.encode('GB2312')
"""