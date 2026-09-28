def reglaFalsa(f, xi, xf, eamax):

    iteraciones = 0
    xr_anterior = xi

    while True:
        xr = xf - (f(xf) * (xi - xf)) / (f(xi) - f(xf))
        iteraciones += 1

        if iteraciones > 1:
            ea = abs((xr - xr_anterior) / xr) * 100
            if ea < eamax:
                break

        if f(xi) * f(xr) < 0:
            xf = xr
        else:
            xi = xr

        xr_anterior = xr

    return xr, f(xr), iteraciones