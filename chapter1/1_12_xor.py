# 1. 计算异或结果res
# 2. 在nums中找到一个数，该数在res最高位上的位为1，则直接将该数与res再次异或

def cal(nums):
	res = 0
	for num in nums:
		res ^= num
	# 去掉开头二进制的表示0b
	res = bin(res)
	print('xor: ', res)
	if res == '0b0':
		return nums
	shift = len(res)-3
	change_index = -1
	for index, num in enumerate(nums):
		if (num>>shift)&1 == 1:
			# 需要修改的位数
			change_index = index
			break
	nums[change_index] ^= int(res, 2)
	return nums


if __name__ == '__main__':
	nums = [6,26, 29]
	cal(nums)
	print(nums)

