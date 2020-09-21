# 给定一些会议的开始结束时间，求最少的会议室


meetings = [
	# [6, 15],
	# [3, 6],
	# [6, 12],
	# [30, 45],
	# [12, 15],
	# [1, 30], 
	# [15, 29],
	[3, 4],
	[2, 3],
	[3, 6]
]

def cal():
	# 先把会议按照开始时间排序
	meetings.sort(key=lambda meeting : meeting[0])
	meeting_rooms = []
	conflict = True
	# 遍历每个meeting，
	for meeting in meetings:
		# 看是否和现在的会议室有冲突
		if meeting_rooms is None:
			meeting_rooms.append(meeting)
		else:
			for meeting_room in meeting_rooms:
				# 如果会议开始时间大于会议室结束时间，没有冲突
				if meeting[0] >= meeting_room[1]: 
					meeting_room[1] += meeting[1]-meeting[0]
					conflict = False
					break
			if conflict:
				meeting_rooms.append(meeting)
		conflict = True

	return meeting_rooms


# 不用排序试试
def cal_no_sort():
	# 先把会议按照开始时间排序
	meeting_rooms = []
	conflict = True
	# 遍历每个meeting，
	for meeting in meetings:
		# 看是否和现在的会议室有冲突
		if meeting_rooms is None:
			meeting_rooms.append(meeting)
		else:
			for meeting_room in meeting_rooms:
				# 如果会议开始时间大于会议室结束时间，没有冲突
				if meeting[0] >= meeting_room[1]: 
					meeting_room[1] = meeting[1]
					conflict = False
					break
				elif meeting[1] <= meeting_room[0]:
					meeting_room[0] = meeting[0]
					conflict = False
					break
			if conflict:
				meeting_rooms.append(meeting)
		conflict = True

	return meeting_rooms


def cal_only_sort():
	# 第一个是时间，第二个是类型(start/end)
	times = []
	for meeting in meetings:
		times.append((meeting[0], 'b'))
		times.append((meeting[1], 'e'))
	# times = sorted(times, key=lambda time : (time[0], time[1]))
	times = sorted(times, key=lambda time : (time[0], time[1]))
	print(times)
	max_room = 0
	temp_room = 0
	for time in times:
		if time[1] == 'b':
			temp_room += 1
			if temp_room > max_room:
				max_room = temp_room
		else:
			temp_room -= 1
	return max_room


if __name__ == '__main__':
	# print(cal())
	# print(cal_no_sort())
	print(cal_only_sort())


