#!/bin/bash
#SBATCH --mail-type=ALL        
#SBATCH --mail-user=rutgerluther@u.boisestate.com  # Email address
#SBATCH -J serial             # Job name
#SBATCH -o serial.o%j        # output and error file name (%j expands to jobID)
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
srun -n 1 --exclusive make serial
srun -n 1 --exclusive bin/CalculatingPI 100000000

exit 0
