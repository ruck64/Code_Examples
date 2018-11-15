#!/bin/bash
#SBATCH --mail-type=ALL        
#SBATCH --mail-user=rutgerluther@u.boisestate.com  # Email address
#SBATCH -J Pi1             # Job name
#SBATCH -o log_moose.o%j        # output and error file name (%j expands to jobID)
#SBATCH -n 1                   # Number of cpu cores per task ( 28 per node )
#SBATCH -p defq                 # queue (partition) -- defq, ipowerq, eduq.
#SBATCH -t 00:05:00             # run time (hh:mm:ss) - 1 hours in this example.

echo -e "***** Sourcing (loading) modules \n"

# Load Modules
module purge all
module load slurm

# Move to submission directory
cd $SLURM_SUBMIT_DIR

# Name of the Input File in current directory
NAME=2d_diffusion_test.i

exit 0
