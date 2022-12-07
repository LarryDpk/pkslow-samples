from numba import cuda
import os

def cpu_print():
    print('cpu print')


@cuda.jit
def gpu_print():
    dataIndex = cuda.threadIdx.x + cuda.blockIdx.x * cuda.blockDim.x
    print('gpu print ', cuda.threadIdx.x, cuda.blockIdx.x, cuda.blockDim.x, dataIndex)


if __name__ == '__main__':
    gpu_print[4, 4]()
    cuda.synchronize()
    cpu_print()
