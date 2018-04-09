#!/usr/bin/env python
import sys
import os
import main_module as analizer

def main(argv):

    return analizer.analize(argv[0])


if __name__ == "__main__":
    main(sys.argv[1:])
