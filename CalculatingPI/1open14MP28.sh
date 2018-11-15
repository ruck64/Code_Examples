#!/bin/bash
#SBATCH --mail-type=ALL        
#SBATCH --mail-user=rutgerluther@u.boisestate.com  # Email address
#SBATCH -J piMP28             			   # Job name
#SBATCH --cpus-per-task=28    			   #Reques a full node
#SBATCH -o log_moose.o%j        		   # output and error file name (%j expands to jobID)
#SBATCH -n 1                   		   # Number of cpu cores per task ( 28 per node )
#SBATCH -p shortq                 		   # queue (partition) -- defq, ipowerq, eduq.
#SBATCH -t 00:05:00             		   # run time (hh:mm:ss) - 1 hours in this example.

echo -e "***** Sourcing (loading) modules \n"

# Load Modules
module purge
module load slurm
module load gcc/7.2.0

# To run
srun -n 1 --exclusive make MP
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 1 
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 14
srun -n 1 --exclusive bin/CalculatingPI_MP 1000000000 28

exit 0
