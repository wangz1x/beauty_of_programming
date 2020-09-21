# 4张牌，面值为1~13，可重复，计算是否可能通过四则运算得到结果为24
import math

numbers = 4
max_ = 2**4

# 保存中间结果
res = [set([]) for i in range(max_)]

cards = [2,1,4,3]

def f(x):
	'''
	x 为 1~2^4 之间的数，用于表示哪些牌的组合
	'''
	# 如果有两张以上的牌，
	# 1. 判断res数组中是否已经有该组合的结果了
	# 2. 没有就递归分开
	# print('call f(',x,')', '\n')
	if len(res[x]) != 0:
		return res[x]
	elif x==1 or x==2 or x==4 or x==8:	# x取这些值时，说明只有一张牌，直接返回
		res[x].add(cards[int(math.log(x, 2))])
		return res[x]
	else:
		for i in range(1, x):	# 要比x小，才可能为x的真子集
			if x & i == i:	# 此时为x的真子集
				res[x]=res[x].union(union(f(i), f(x-i)))
				# print('res[',x,']: ',res[x])
		return res[x]


def union(l1, l2):
	'''
	对两个集合中的数，分别做四则运算
	'''
	# print(l1)
	# print(l2, '\n')
	res_set = set([])
	for x in l1:
		for y in l2:
			res_set.add(x+y)
			res_set.add(x-y)
			res_set.add(y-x)
			res_set.add(x*y)
			if x!=0:
				res_set.add(y/x)
			if y!=0:
				res_set.add(x/y)
	return res_set


if __name__ == '__main__':
	f(15)
	# print(res[15])
	if 24 in res[15]:
		print(True)
	else:
		print(False)

