program {
  int factorial(int n) {
      if (n < 2) then 
         { return 1 }
      else 
         {return n*factorial(n-1) }
  }
  write(factorial(read()))
}

// .x files are irrelevant for coding, only use for reference