#!/bin/python3

from codicefiscale import codicefiscale
from sys import argv

print(codicefiscale.encode(argv[1], argv[2], argv[3], argv[4], argv[5]))
