# 从第一个非安全局面出发，根据规律往后找新的非安全局面，
# 直到查找范围到达了目标石头数，然后判断是否符合非安全局面
import time
import copy
# 对于先取者来说是否安全
def nim(n, m):
	if n == m:
		return True
	# 保持n小于m
	if n > m:
		n = n + m
		m = n - m
		n = n - m
	exist = [0]

	recursion = 1
	a = 0
	b = 0

	while a < n:
		# find min which doesn't exist in the list
		n_min = find_lack_min(exist, min(a,b))
		# print('n_min: ', n_min)
		a = n_min
		b = a + recursion
		recursion += 1
		exist.append(a)
		exist.append(b)
	print('a: ', a, ' b: ', b)
	# 如果相等的话，说明现在是非安全情况，先取者必输
	if a == n and b == m:
		return False
	else:
		return True


def find_lack_min(l, begin):
	# 当l数组过大时查找耗时，
	if len(l) > 100:
		for comp in l:
			if comp < begin:
				l.remove(comp)
	while True:
		if not begin in l:
			break
		begin += 1
	return begin


if __name__ == '__main__':
	start = time.time()
	print(nim(15975, 9873))
	print('time: ', time.time()-start)
