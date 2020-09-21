# 五种类书，不同类型一起买可以打折
# 2    5%
# 3    10%
# 4    20%
# 5    25%

# list.sort(reverse=True)

# 获取输入，将输入降序处理，初始化dp数组，开始遍历

def buy_book(books):
    books.sort(reverse=True)

    discount = [0, 0.05, 0.1, 0.2, 0.25]
    price = 8
    dp = [[[[[0 for i in range(books[4]+1)] for i in range(books[3]+1)] for i in range(books[2]+1)] for i in range(books[1]+1)] for i in range(books[0]+1)]

    for i in range(books[4]+1):
        for j in range(books[3]+1):
            for k in range(books[2]+1):
                for l in range(books[1]+1):
                    for m in range(books[0]+1):
                        temp_book = [i, j, k, l, m]
                        temp_book.sort(reverse=True)
                        choose = []
                        # 最大的等于0，那么其他也等于0了
                        if temp_book[0] == 0:
                            choose.append(0)
                        else:
                            for n in range(len(temp_book)):
                                if temp_book[n] >= 1:
                                    for o in range(n+1):
                                        temp_book[o] -= 1
                                    temp = sorted(temp_book, reverse=True)
                                    choose.append(price*(n+1)*(1-discount[n])+dp[temp[0]][temp[1]][temp[2]][temp[3]][temp[4]])
                                    for o in range(n+1):
                                        temp_book[o] += 1
                        dp[temp_book[0]][temp_book[1]][temp_book[2]][temp_book[3]][temp_book[4]] = min(choose)
    print("min: ", dp[books[0]][books[1]][books[2]][books[3]][books[4]])

if __name__ == '__main__':
    my_books = [2,7, 6, 3,5]
    buy_book(my_books)
