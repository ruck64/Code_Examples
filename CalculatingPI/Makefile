CC=gcc
CPP=g++
FLAGS=-lpthread -g
OBJ=obj
SRC=src
BIN=bin
CPPFLAGS=-I$(SRC) 
GTEST_DIR=../googletest/googletest
MKDIR=mkdir -p 

pthread:directories $(OBJ)/pi.o $(OBJ)/pthreadDriver.o
	$(CPP) $(FLAGS) -I$(SRC) $(SRC)/pi.c $(SRC)/pthreadDriver.c -o $(BIN)/CalculatingPI_pthread


MP:directories $(OBJ)/piMP.o $(OBJ)/piMPDriver.o
	$(CPP) $(FLAGS) -I$(SRC) $(SRC)/piMP.c $(SRC)/piMPDriver.c -o $(BIN)/CalculatingPI_MP -fopenmp
	
serial:directories $(OBJ)/piDriver.o
	$(CPP) $(FLAGS) -I$(SRC) $(SRC)/piDriver.c -o $(BIN)/CalculatingPI

gtest: directories
	${CPP} -I${GTEST_DIR}/include -I${GTEST_DIR} \
    -pthread -c ${GTEST_DIR}/src/gtest-all.cc -o $(OBJ)/gtest-all.o
	ar -rv $(OBJ)/libgtest.a $(OBJ)/gtest-all.o
	
directories:
	$(MKDIR) bin
	$(MKDIR) obj
	
$(BIN)/Pi: $(OBJ)/pi.o
	$(CC) $(CFLAGS) $< -o $@	

GTEST_SRCS_ = $(GTEST_DIR)/src/*.cc $(GTEST_DIR)/src/*.h $(GTEST_HEADERS)

$(OBJ)/gtest_main.o : $(GTEST_SRCS_)
	$(CXX) $(CPPFLAGS) -I${GTEST_DIR}/include -I$(GTEST_DIR) $(CXXFLAGS) -c \
            $(GTEST_DIR)/src/gtest_main.cc -o $@

$(OBJ)/gtest_main.a : $(OBJ)/gtest-all.o $(OBJ)/gtest_main.o
	$(AR) $(ARFLAGS) $@ $^

$(OBJ)/%.o: $(SRC)/%.cpp
	$(CPP) $(CPPFLAGS) $(CXXFLAGS) -c -o $@ $<
	
$(OBJ)/%.o: $(SRC)/%.c
	$(CC) $(CFLAGS) -c -o $@ $<

.PHONY: test clean serial

test: $(OBJ)/gtest_main.a $(OBJ)/pi.o
	$(CPP) -I${GTEST_DIR}/include -pthread $(SRC)/PiTest.cpp \
         $(OBJ)/gtest_main.a $(OBJ)/pi.o -o $(BIN)/PiTest
	$(BIN)/PiTest

clean:
	rm -rf $(BIN)
	rm -rf $(OBJ)


