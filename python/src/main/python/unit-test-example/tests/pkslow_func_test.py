import unittest
from .context import src


class SumTest(unittest.TestCase):
    def test_Sum(self):
        self.assertEqual(src.Sum(1, 1), 2)
        self.assertTrue(src.Sum(1, 2) == 3)