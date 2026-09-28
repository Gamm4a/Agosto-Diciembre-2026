from math import sin, exp

from biseccion import biseccion
from reglaFalsa import reglaFalsa
from newtonRaphson import newtonRaphson
from secante import secante


# Función f(x)
def f(x):
    return x**4 - 8*x**3 - 35*x**2 + 450*x - 1001


# Derivada de f(x)
def df(x):
    return 4*x**3 - 24*x**2 - 70*x + 450


# Función g(x)
def g(x):
    return 8 * sin(x) * exp(-x) - 1


print("MÉTODO BISECCIÓN")

raiz, y, it = biseccion(f, -7.5, -7.2, 0.0001)
print(f"Raíz: {raiz:.6f}")
print(f"f(raíz): {y:.6f}")
print(f"Iteraciones: {it}\n")

raiz, y, it = biseccion(f, 5.0, 6.0, 0.0001)
print(f"Raíz: {raiz:.6f}")
print(f"f(raíz): {y:.6f}")
print(f"Iteraciones: {it}\n")


print("MÉTODO REGLA FALSA")

raiz, y, it = reglaFalsa(g, 0.0, 1.0, 0.0001)
print(f"Raíz: {raiz:.6f}")
print(f"f(raíz): {y:.6f}")
print(f"Iteraciones: {it}\n")

raiz, y, it = reglaFalsa(g, 1.5, 2.5, 0.0001)
print(f"Raíz: {raiz:.6f}")
print(f"f(raíz): {y:.6f}")
print(f"Iteraciones: {it}\n")


print("MÉTODO NEWTON-RAPHSON")

raiz, y, it = newtonRaphson(f, df, -7.0, 0.0001)
print(f"Raíz: {raiz:.6f}")
print(f"f(raíz): {y:.6f}")
print(f"Iteraciones: {it}\n")

raiz, y, it = newtonRaphson(f, df, 5.5, 0.0001)
print(f"Raíz: {raiz:.6f}")
print(f"f(raíz): {y:.6f}")
print(f"Iteraciones: {it}\n")


print("MÉTODO SECANTE")

raiz, y, it = secante(g, 0.0, 1.0, 0.0001)
print(f"Raíz: {raiz:.6f}")
print(f"f(raíz): {y:.6f}")
print(f"Iteraciones: {it}\n")

raiz, y, it = secante(g, 1.5, 2.5, 0.0001)
print(f"Raíz: {raiz:.6f}")
print(f"f(raíz): {y:.6f}")
print(f"Iteraciones: {it}")
