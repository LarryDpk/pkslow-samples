import unittest
import mock
from .context import src


class RandomTest(unittest.TestCase):
    @mock.patch('os.urandom')
    def test_Random(self, random_mock):
        random_mock.return_value = 'aaa'
        self.assertEqual(src.Random(2), '2aaa')
