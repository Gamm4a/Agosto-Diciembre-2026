def secante(f, x1, x2, eamax):

    iteraciones = 0

    while True:
        x_anterior = x2

        x2 = x2 - (f(x2) * (x1 - x2)) / (f(x1) - f(x2))

        iteraciones += 1

        ea = abs((x2 - x_anterior) / x2) * 100

        if ea < eamax:
            break

        x1 = x_anterior

    return x2, f(x2), iteraciones