
def main():

    input_direction = str(input("Select transform direction (CF) or (FC): "))
    if input_direction.upper() not in ["CF", "FC"]:
        print("Not valid input")
        return
    try:
        input_temp = float(input("Input temperature: "))
    except:
        print("Not valid input")
        exit()

    if (input_direction.upper() == "CF"):
        print("{} C = {} F".format(input_temp, t_transform(input_temp, 'c')))
    if (input_direction.upper() == "FC"):   
        print("{} F = {} C".format(input_temp, f_transform(input_temp, 'c')))


def t_transform(temp, type):

    if type == 'c':
        return float(temp * 9/5 + 32)

    return None

def f_transform(temp, type):

    if type == 'c':
        return float((temp-32) * 5/9)

    return None


if __name__ == "__main__":
    main()
