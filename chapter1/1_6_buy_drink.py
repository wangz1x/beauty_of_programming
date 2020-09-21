'''
购买饮料，总容量为 V
每种饮料有如下信息： (s, v, c, h, b) 分别表示: (饮料名称，单容量，上限，价值，实际购买量)

求解使得价值最大的买法
'''

drink = [
	['a', 2, 10, 1],
	['ab', 4, 5, 2],
	['ac', 8, 10, 1],
	['ad', 16, 10, 1],
	['ae', 8, 10, 1],
	['af', 32, 10, 1],
	['ag', 16, 10, 1],
	['agg', 4, 9, 1],
]

def cal(V, T):
	'''
	V: 总容量(背包大小)
	T: 饮料种类数
	'''
	# dp[i][j] 表示容量为i，只选择前j种饮料，能达到的最大价值
	dp = [[0 for i in range(T+1)] for i in range(V+1)]

	for v in range(1, V+1):

		for t in range(1, T+1):

			# 遍历第t种饮料的数量
			for c in range(drink[t-1][2]+1):
				# 如果拿 c瓶 t号 饮料的容量已经超过限制了
				if c*drink[t-1][1] > v:
					break
				# 当前最优值为，拿c瓶 t号 饮料的价值和抛去c瓶t号饮料占的容量，只考虑前t-1种饮料的价值之和与当前vt的最大值
				else:
					dp[v][t] = max(dp[v][t], c*drink[t-1][3]+dp[v-c*drink[t-1][1]][t-1])
	t = T
	for v in range(V, 0, -1):
		while t >= 1:
			x = dp[v][t] - dp[v][t-1]
			if x > 0:
				print('type: ', t, ' count: ', x/drink[t-1][3])
				break
			t -= 1
		t -= 1

	return dp[V][T]


def cal2(V, T):
	'''
	直接计算单位体积幸福值
	'''
	happ_ = []
	for index, d in enumerate(drink) :
		happ_.append((index, d[3]/d[1]))
	print(happ_)
	# sort
	happ_ = sorted(happ_, key=lambda tple : (tple[1], drink[tple[0]][1]), reverse=True)
	print(happ_)
	happness = 0
	vol = 0
	# # 从单位价值最高的开始取
	# for happ in happ_:
	# 	for count in range(1, drink[happ[0]][2]+1):


if __name__ == '__main__':
	print(cal2(100, 8))
