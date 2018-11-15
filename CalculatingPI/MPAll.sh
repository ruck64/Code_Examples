#!/bin/bash
#SBATCH --mail-type=ALL        
#SBATCH --mail-user=rutgerluther@u.boisestate.com  # Email address
#SBATCH -J threads             # Job name
#SBATCH -o MP.o%j        # output and error file name (%j expands to jobID)
#SBATCH -n 1                   # Number of cpu cores per task ( 28 per node )
#SBATCH --cpus-per-task=28     #Request a fulle node
#SBATCH -p shortq                 # queue (partition) -- defq, ipowerq, eduq.
#SBATCH -t 00:05:00             # run time (hh:mm:ss) - 1 hours in this example.

echo -e "***** Sourcing (loading) modules \n"

# Load Modules
module purge
module load slurm
module load gcc/7.2.0

# To run
srun -n 1 --exclusive make MP
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 1 
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 2 
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 3 
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 4 
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 5 
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 6 
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 7 
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 8 
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 9 
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 10 
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 11
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 12 
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 13 
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 14
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 15 
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 16 
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 17 
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 18 
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 19 
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 20 
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 21 
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 22
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 23 
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 24
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 25
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 26
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 27
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 28

exit 0
