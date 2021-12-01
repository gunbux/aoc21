with open('1.txt') as input:
    g = [int(h.rstrip()) for h in input]
    ##print(g)

    count = 0
    ## Part 1
    ## for t in enumerate(g):
    ##     p = t[0]
    ##     i = t[1]
    ##     if p - 1 < 0:
    ##         continue
    ##     if g[p] > g[p - 1]:
    ##         count += 1

    ## print(count)

    ## Part 2

    def get_sum(g, i):
        if i < 0:
            return 0
        return g[i] + g[i + 1] + g[i + 2]

    for t in enumerate(g):
        p = t[0]
        i = t[1]
        if p + 3 >= len(g):
            continue
        sum = get_sum(g, p)
        prev = get_sum(g, p - 1)
        if sum > prev:
            count += 1


    print(count)
