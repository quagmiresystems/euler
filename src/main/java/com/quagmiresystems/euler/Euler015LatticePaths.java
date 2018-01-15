package com.quagmiresystems.euler;

public class Euler015LatticePaths {

    static int size = 4;
    static int count = 0;

    public static void main(String[] args) {
        for (int i1 = 0; i1 <= size; i1++) {
            for (int i2 = i1 + 1; i2 <= size + 1; i2++) {
                for (int i3 = i2 + 1; i3 <= size + 2; i3++) {
                    for (int i4 = i3 + 1; i4 <= size + 3; i4++) {
//                        for (int i5 = i4 + 1; i5 <= size + 4; i5++) {
//                            for (int i6 = i5 + 1; i6 <= size + 5; i6++) {
//                                for (int i7 = i6 + 1; i7 <= size + 6; i7++) {
//                                    for (int i8 = i7 + 1; i8 <= size + 7; i8++) {
//                                        for (int i9 = i8 + 1; i9 <= size + 8; i9++) {
//                                            for (int i10 = i9 + 1; i10 <= size + 9; i10++) {
//                                                for (int i11 = i10 + 1; i11 <= size + 10; i11++) {
//                                                    for (int i12 = i11 + 1; i12 <= size + 11; i12++) {
//                                                        for (int i13 = i12 + 1; i13 <= size + 12; i13++) {
//                                                            for (int i14 = i13 + 1; i14 <= size + 13; i14++) {
//                                                                for (int i15 = i14 + 1; i15 <= size + 14; i15++) {
//                                                                    for (int i16 = i15 + 1; i16 <= size + 15; i16++) {
//                                                                        for (int i17 = i16 + 1; i17 <= size + 16; i17++) {
//                                                                            for (int i18 = i17 + 1; i18 <= size + 17; i18++) {
//                                                                                for (int i19 = i18 + 1; i19 <= size + 18; i19++) {
//                                                                                    for (int i20 = i19 + 1; i20 <= size + 19; i20++) {
                    count++;
                    char[] path = {'0', '0', '0', '0', '0', '0','0','0'};
                    path[i1] = '1';
                    path[i2] = '1';
                    path[i3] = '1';
                    path[i4] = '1';
                    System.out.println(new String(path));
//                                                                                    }
//                                                                                }
//                                                                            }
//                                                                        }
//                                                                    }
//                                                                }
//                                                            }
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
                    }
                }
            }
        }
        System.out.println();
        System.out.println(count);
        calc(4);
    }
    
    public static void calc(int size) {
        count = 0;
        for(int i=1;i<=size;i++) {
            count += i*(size+i);
        }
        System.out.println(count);
        System.out.println((8+7*2+6*3+5*4)*2);
        System.out.println((5+4+3+2+1+4+3+2+1+3+2+1+2+1+1)*2);
        System.out.println((3+2+1+2+1+1)*2);
        System.out.println((10+9+8+7+6)*2);
    }

}
