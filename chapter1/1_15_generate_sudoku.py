# 生成有效数独
matrix = [[-1 for i in range(9)] for i in range(9)]

def get_valid_value(x, y):
	'''
	获取坐标为x，y的点的所有可能值
	即，不和 横，纵，小三角重复的值
	'''
	res = []
	for i in range(1, 10):
		if i not in get_row(x, y) and i not in get_column(x, y) and i not in get_min_matrix(x, y):
			res.append(i)
	return res


def get_row(x, y):
	return matrix[x]


def get_column(x, y):
	res = []
	for row in matrix:
		res.append(row[y])
	return res


def get_min_matrix(x, y):
	res = []
	left_top_x = int(x/3) * 3
	left_top_y = int(y/3) * 3
	for n_x in range(left_top_x, left_top_x+3):
		for n_y in range(left_top_y, left_top_y+3):
			res.append(matrix[n_x][n_y])
	return res


def fill_matrix(x, y):
	if x > 8: # 说明全部填完了
		flag = True
		for row in matrix:
			if -1 in row:
				flag = False
				break
		if flag:
			print(matrix)
		return
	valid_values = get_valid_value(x, y)
	# 如果valid_values 为空，就表示当前没得填的值了，需要返回上一层换个值啊
	if len(valid_values) == 0:
		# print(matrix)
		# print(x, y)
		return
	for valid_value in valid_values:
		matrix[x][y] = valid_value
		if y == 8: # 这一行填满了，该填下一行了
			fill_matrix(x+1, 0)
		else:
			fill_matrix(x, y+1)
	matrix[x][y] = -1


if __name__ == '__main__':
	fill_matrix(0, 0)

