def mergesort(dataset):
    if len(dataset) > 1:
        mid = len(dataset) // 2
        leftarr = dataset[:mid]
        rightarr = dataset[mid:]

        # recursively break down the arrays
        mergesort(leftarr)
        mergesort(rightarr)

        # now perform the merging
        i = 0 # index into the left array
        j = 0 # index into the right array
        k = 0 # index into merged array

        while i < len(leftarr) and j < len(rightarr):
            if leftarr[i] < rightarr[j]:
                dataset[k] = leftarr[i]
                i += 1
            else:
                dataset[k] = rightarr[j]
                j += 1
            k += 1
        while i < len(leftarr):
            dataset[k] = leftarr[i]
            i += 1
            k += 1
        while j < len(rightarr):
            dataset[k] = rightarr[j]
            j += 1
            k += 1
    print("Merging: ", dataset)


items = [6, 20, 8, 19, 56, 23, 87, 41, 49, 53]
print("Starting state: ", items)
mergesort(items)
print("Final state: ", items)

