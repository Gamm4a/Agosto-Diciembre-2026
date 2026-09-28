def newtonRaphson(f, df, xi, eamax):
    iteraciones = 0
    xr = xi

    while True:
        xr_anterior = xr
        xr = xr_anterior - (f(xr_anterior) / df(xr_anterior))
        iteraciones += 1

        ea = abs((xr - xr_anterior) / xr) * 100

        if ea < eamax:
            break

    return xr, f(xr), iteraciones