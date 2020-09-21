# 上下电梯

# 假设停在第i层，i层下边的人需要下楼梯，i层上边的人需要上楼梯，比较上的多还是下的多，
# 看电梯继续往上是否能更优

# 每层的人
peo = [4, 2, 6, 1, 9, 8, 0, 3]

# 上楼梯的代价, 下楼梯的代价还是为1
k = 3

def up_down():
	# 先初始化，看电梯停在第1层时，需要上的楼梯，以及对应的N1，N2，N3
	# 下楼梯的人
	N1 = 0
	# 不上不下的人
	N2 = peo[0]
	# 上楼梯的人
	N3 = 0
	# 上和下楼层数的总和
	step = 0
	for i in range(1, len(peo)):
		N3 += peo[i]
		step += i * peo[i]
	print('init energy: ', step*3)

	# 开始看电梯往上停一层是否能取得更好的结果
	stop = 0
	for i in range(1, len(peo)):
		# 
		# 往上一层 N1+N2 的人要多下一层, N3 的人可以少上一层，少耗费3倍的代价
		if N1+N2 < N3*k: # 此时电梯上的利更大
			step -= N3-(N1+N2)
			N1 += N2
			N2 = peo[i]
			N3 -= N2
			stop = i
		else:
			break
	print('wait at: ', stop, ' energy cost: ', N1+N3*k, ' step: ', step)
	return stop, step


if __name__ == '__main__':
	print(up_down())

