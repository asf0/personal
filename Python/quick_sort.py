def quick_sort(dataset, first, last):
    if first < last:
        # calculate the split point
        pivlotIdx = partition(dataset, first, last)
        # now sort the two partitions
        quick_sort(dataset, first, pivlotIdx-1)
        quick_sort(dataset, pivlotIdx+1, last)

def partition(datavalues, first, last):
    # choose the first item as the pivot value
    pivotvalue = datavalues[first]
    
    # establish the upper and lower indexes
    lower = first + 1
    upper = last
    # start searching for the crossing point
    done = False
    while not done:
        # advance the lower index
        while lower <= upper and datavalues[lower] <= pivotvalue:
            lower += 1
        # advance the upper index
        while datavalues[upper] >= pivotvalue and upper >= lower:
            upper -= 1
        # if the two indexes cross, we have found the split point
        if upper < lower:
            done = True
        
            # exchange the two values
        else:
            temp = datavalues[lower]
            datavalues[lower] = datavalues[upper]
            datavalues[upper] = temp

    # when the split point is found, exchange the pivot value
    temp = datavalues[first]
    datavalues[first] = datavalues[upper]
    datavalues[upper] = temp

    # return the split point index
    return upper

items = [6, 20, 8, 19, 56, 23, 87, 41, 49, 53]
print("Starting state: ", items)
quick_sort(items, 0, len(items)-1)
print("Final state: ", items)