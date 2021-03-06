package xrd;

import java.util.ArrayList;
import java.util.List;

public class Ions {

	public static List<Ion> ions;
	
	public Ions() {
		ions = new ArrayList<>(); 
		
		double[] tab = {0.489918,      20.6593,     0.262003,       7.74039,     0.196767,
			       49.5519,     0.049879,      2.20159,     0.001305};
		ions.add(new Ion("H", tab));
		
		double[] tab1 = {0.897661,      53.1368,     0.565616,        15.187,     0.415815,
			       186.576,     0.116973,      3.56709,     0.002389};
		ions.add(new Ion("He1-", tab1));
		
		double[] tab2 = {  1.1282,       3.9546,       0.7508,        1.0524,       0.6175,
			       85.3905,       0.4653,       68.261,       0.0377};
		ions.add(new Ion("Li", tab2));
		
		double[] tab3 = {  0.6968,       4.6237,       0.7888,        1.9557,       0.3414,
				   0.6316,       0.7029,        0.542,       0.0167};
		ions.add(new Ion("Li1+", tab3));
		
		double[] tab4 = {  1.5919,      43.6427,       1.1278,        1.8623,       0.5391,
				103.483,       0.7029,        0.542,       0.0385};
		ions.add(new Ion("Be", tab4));
		
		double[] tab5 = {  6.2603,       0.0027,       0.8849,        0.8313,       0.7993,
				2.2758,       0.1647,       5.1146,      -6.1092};
		ions.add(new Ion("Be2+", tab5));
		
		double[] tab6 = {  2.0545,      23.2185,       1.3326,         1.021,       1.0979,
		       60.3498,       0.7068,       0.1403,      -0.1932};
		ions.add(new Ion("B", tab6));
		
		double[] tab7 = {    2.31,      20.8439,         1.02,       10.2075,       1.5886,
	        0.5687,        0.865,      51.6512,       0.2156};
		ions.add(new Ion("C", tab7));
		
		double[] tab8 = { 12.2126,       0.0057,       3.1322,        9.8933,       2.0125,
			       28.9975,       1.1663,       0.5826,      -11.529};
		ions.add(new Ion("N", tab8));
		
		double[] tab9 = {  3.0485,      13.2771,       2.2868,        5.7011,       1.5463,
				0.3239,        0.867,      32.9089,       0.2508};	
		ions.add(new Ion("O", tab9));
		
		double[] tab10 = {  4.1916,      12.8573,      1.63969,       4.17236,      1.52673,
			    -47.0179,       20.307,     -0.01404,      21.9412};	
		ions.add(new Ion("O2-", tab10));
		
		double[] tab11 = {  3.5392,      10.2825,       2.6412,        4.2944,        1.517,
				0.2615,       1.0243,      26.1476,       0.2776};	
		ions.add(new Ion("F", tab11));
		
		double[] tab12 = {  3.6322,      5.27756,      3.51057,       14.7353,      1.26064,
				0.442258,     0.940706,      47.3437,     0.653396};	
		ions.add(new Ion("F1-", tab12));
		
		double[] tab13 = {  4.7626,        3.285,       3.1736,        8.8422,       1.2674,
				0.3136,       1.1128,      129.424,        0.676};	
		ions.add(new Ion("Na", tab13));
		
		double[] tab14 = {  3.2565,       2.6671,       3.9362,        6.1153,       1.3998,
				0.2001,       1.0032,       14.039,        0.404};	
		ions.add(new Ion("Na1+", tab14));
		
		double[] tab15 = {  5.4204,       2.8275,       2.1735,       79.2611,       1.2269,
				0.3808,       2.3073,       7.1937,       0.8584};	
		ions.add(new Ion("Mg", tab15));
		
		double[] tab16 = {  3.4988,       2.1676,       3.8378,        4.7542,       1.3284,
				0.185,       0.8497,      10.1411,       0.4853};	
		ions.add(new Ion("Mg2+", tab16));
		
		double[] tab17 = {  6.4202,       3.0387,       1.9002,        0.7426,       1.5936,
		       31.5472,       1.9646,      85.0886,       1.1151};	
		ions.add(new Ion("Al", tab17));
		
		double[] tab18 = { 4.17448,      1.93816,       3.3876,       4.14553,      1.20296,
		      0.228753,     0.528137,      8.28524,     0.706786};	
		ions.add(new Ion("Al3+", tab18));
		
		double[] tab19 = {  6.2915,       2.4386,       3.0353,       32.3337,       1.9891,
		        0.6785,        1.541,      81.6937,       1.1407};	
		ions.add(new Ion("Si", tab19));
		
		double[] tab20 = { 4.43918,      1.64167,      3.20345,       3.43757,      1.19453,
	         0.2149,      0.41653,      6.65365,     0.746297};	
		ions.add(new Ion("Si4+", tab20));
		
		double[] tab21 = {  6.4345,       1.9067,       4.1791,        27.157,         1.78,
	          0.526,       1.4908,      68.1645,       1.1149};	
		ions.add(new Ion("P", tab21));

		double[] tab22 = {  6.9053,       1.4679,       5.2034,       22.2151,       1.4379,
	         0.2536,       1.5863,       56.172,       0.8669};	
		ions.add(new Ion("S", tab22));	 

		double[] tab23 = { 11.4604,       0.0104,       7.1964,        1.1662,       6.2556,
		         18.5194,       1.6455,      47.7784,      -9.5574};	
		ions.add(new Ion("Cl", tab23));	
		
		double[] tab24 = { 18.2915,       0.0066,       7.2084,        1.1717,       6.5337,
		         19.5424,       2.3386,      60.4486,      -16.378}	;	
		ions.add(new Ion("Cl1-", tab24));	
		
		double[] tab25 = {  8.2186,      12.7949,       7.4398,        0.7748,       1.0519,
			       213.187,       0.8659,      41.6841,       1.4228};	
		ions.add(new Ion("K", tab25));
		  	   
		double[] tab26 = {  8.6266,      10.4421,       7.3873,        0.6599,       1.5899,
	       85.7484,       1.0211,      178.437,       1.3751};	
		ions.add(new Ion("Ca", tab26));
		
		double[] tab27 = { 15.6348,      -0.0074,       7.9518,        0.6089,       8.4372,
			       10.3116,       0.8537,      25.9905,      -14.875};	
		ions.add(new Ion("Ca2+", tab27));
				
		double[] tab28 = {   9.189,       9.0213,       7.3679,        0.5729,       1.6409,
					136.108,        1.468,      51.3531,       1.3329};	
		ions.add(new Ion("Sc", tab28));
		
		double[] tab29 = { 13.4008,      0.29854,       8.0273,        7.9629,      1.65943,
					-0.28604,      1.57936,      16.0662,      -6.6667};	
		ions.add(new Ion("Sc3+", tab29));
		
		double[] tab30 = {  9.7595,       7.8508,       7.3558,           0.5,       1.6991,
					35.6338,       1.9021,      116.105,       1.2807};	
		ions.add(new Ion("Ti", tab30));
		
		double[] tab31 = { 9.11423,       7.5243,      7.62174,      0.457585,       2.2793,
					19.5361,     0.087899,      61.6558,     0.897155};	
		ions.add(new Ion("Ti2+", tab31));
		
		double[] tab32 = { 17.7344,      0.22061,      8.73816,       7.04716,      5.25691,
					-0.15762,      1.92134,      15.9768,      -14.652};	
		ions.add(new Ion("Ti3+", tab32));
		
		double[] tab33 = { 19.5114,     0.178847,      8.23473,       6.67018,      2.01341,
				-0.29263,       1.5208,      12.9464,       -13.28};	
		ions.add(new Ion("Ti4+", tab33));
		
		double[] tab34 = { 10.2971,       6.8657,       7.3511,        0.4385,       2.0703,
				26.8938,       2.0571,      102.478,       1.2199};	
		ions.add(new Ion("V", tab34));
		
		double[] tab35 = {  10.106,       6.8818,       7.3541,        0.4409,       2.2884,
				20.3004,       0.0223,      115.122,       1.2298};	
		ions.add(new Ion("V2+", tab35));
		
		double[] tab36 = { 9.43141,      6.39535,       7.7419,      0.383349,      2.15343,
				15.1908,     0.016865,       63.969,     0.656565};	
		ions.add(new Ion("V3+", tab36));
		
		double[] tab37 =  { 15.6887,     0.679003,      8.14208,       5.40135,      2.03081,
				9.97278,       -9.576,     0.940464,       1.7143};	
		ions.add(new Ion("V5+", tab37));
		
		double[] tab38 = { 10.6406,       6.1038,       7.3537,         0.392,        3.324,
				20.2626,       1.4922,      98.7399,       1.1832};	
		ions.add(new Ion("Cr", tab38));
		
		double[] tab39 = { 9.54034,      5.66078,       7.7509,      0.344261,      3.58274,
				13.3075,     0.509107,      32.4224,     0.616898};	
		ions.add(new Ion("Cr2+", tab39));
		
		double[] tab40 = {  9.6809,      5.59463,      7.81136,      0.334393,      2.87603,
				12.8288,     0.113575,      32.8761,     0.518275};	
		ions.add(new Ion("Cr3+", tab40));
		
		double[] tab41 = { 11.2819,       5.3409,       7.3573,        0.3432,       3.0193,
				17.8674,       2.2441,      83.7543,       1.0896};	
		ions.add(new Ion("Mn", tab41));
		
		double[] tab42 = { 10.8061,       5.2796,        7.362,        0.3435,       3.5268,
				14.343,       0.2184,      41.3235,       1.0874};	
		ions.add(new Ion("Mn2+", tab42));
		
		double[] tab43 =  { 9.84521,      4.91797,      7.87194,      0.294393,      3.56531,
				10.8171,     0.323613,      24.1281,     0.393974};	
		ions.add(new Ion("Mn3+", tab43));
		
		double[] tab44 = { 9.96253,       4.8485,      7.97057,      0.283303,      2.76067,
				10.4852,     0.054447,       27.573,     0.251877};	
		ions.add(new Ion("Mn4+", tab44));
		
		double[] tab45 =  { 11.7695,       4.7611,       7.3573,        0.3072,       3.5222,
				15.3535,       2.3045,      76.8805,       1.0369};	
		ions.add(new Ion("Fe", tab45));
		
		double[] tab46 =  { 11.0424,       4.6538,        7.374,        0.3053,       4.1346,
				12.0546,       0.4399,      31.2809,       1.0097};	
		ions.add(new Ion("Fe2+", tab46));
		
		double[] tab47 = { 11.1764,       4.6147,       7.3863,        0.3005,       3.3948,
				11.6729,       0.0724,      38.5566,       0.9707};	
		ions.add(new Ion("Fe3+", tab47));
		
		double[] tab48 = { 12.2841,       4.2791,       7.3409,        0.2784,       4.0034,
				13.5359,       2.3488,      71.1692,       1.0118};	
		ions.add(new Ion("Co", tab48));
		
		double[] tab49 = { 11.2296,       4.1231,       7.3883,        0.2726,       4.7393,
				10.2443,       0.7108,      25.6466,       0.9324};	
		ions.add(new Ion("Co2+", tab49));
		
		double[] tab50 = {  10.338,      3.90969,      7.88173,      0.238668,      4.76795,
				8.35583,     0.725591,      18.3491,     0.286667};	
		ions.add(new Ion("Co", tab50));
		
		double[] tab51 = { 12.8376,       3.8785,        7.292,        0.2565,       4.4438,
				12.1763,         2.38,      66.3421,       1.0341};	
		ions.add(new Ion("Ni", tab51));
		
		double[] tab52 = { 11.4166,       3.6766,       7.4005,        0.2449,       5.3442,
				8.873,       0.9773,      22.1626,       0.8614};	
		ions.add(new Ion("Ni2+", tab52));
		
		double[] tab53 = { 10.7806,       3.5477,      7.75868,       0.22314,      5.22746,
				7.64468,     0.847114,      16.9673,     0.386044};	
		ions.add(new Ion("Ni3+", tab53));
		
		double[] tab54 = {  13.338,       3.5828,       7.1676,         0.247,       5.6158,
				11.3966,       1.6735,      64.8126,        1.191};	
		ions.add(new Ion("Cu", tab54));
		
		double[] tab55 = { 11.9475,       3.3669,       7.3573,        0.2274,       6.2455,
				8.6625,       1.5578,      25.8487,         0.89};	
		ions.add(new Ion("Cu1+", tab55));
		
		double[] tab56 = { 11.8168,      3.37484,      7.11181,      0.244078,      5.78135,
				7.9876,      1.14523,       19.897,      1.14431};	
		ions.add(new Ion("Cu2+", tab56));
		
		double[] tab57 = { 14.0743,       3.2655,       7.0318,        0.2333,       5.1652,
				10.3163,         2.41,      58.7097,       1.3041};	
		ions.add(new Ion("Zn", tab57));
		
		double[] tab58 = { 11.9719,       2.9946,       7.3862,        0.2031,       6.4668,
				7.0826,        1.394,      18.0995,       0.7807};
		ions.add(new Ion("Zn2+", tab58));
		
		double[] tab59 = { 17.1789,       2.1723,       5.2358,       16.5796,       5.6377,
				0.2609,       3.9851,      41.4328,       2.9557};	
		ions.add(new Ion("Br", tab59));
		
		double[] tab60 = { 17.1718,       2.2059,       6.3338,       19.3345,       5.5754,
				0.2871,       3.7272,      58.1535,       3.1776};	
		ions.add(new Ion("Br1-", tab60));
		
		double[] tab61 = { 19.2808,       0.6446,      16.6885,        7.4726,       4.8045,
				24.6605,       1.0463,      99.8156,        5.179};	
		ions.add(new Ion("Ag", tab61));
		
		double[] tab62 = { 19.1812,     0.646179,      15.9719,       7.19123,      5.27475,
				21.7326,     0.357534,      66.1147,      5.21572};	
		ions.add(new Ion("Ag1+", tab62));
		
		double[] tab63 = { 19.1643,     0.645643,      16.2456,       7.18544,       4.3709,
				21.4072,            0,            0,      5.21404};	
		ions.add(new Ion("Ag2+", tab63));
		
		double[] tab64 = { 20.1472,        4.347,      18.9949,        0.3814,       7.5138,
				27.766,       2.2735,      66.8776,       4.0712};	
		ions.add(new Ion("I", tab64));
		
		double[] tab65 =  { 20.2332,       4.3579,       18.997,        0.3815,       7.8069,
				29.5259,       2.8868,      84.9304,       4.0714};	
		ions.add(new Ion("I1-", tab65));
		
		double[] tab66 = { 27.0059,      1.51293,      17.7639,       8.81174,      15.7131,
				0.424593,       5.7837,      38.6103,      11.6883};	
		ions.add(new Ion("Pt", tab66));
		
		double[] tab67 =  { 29.8429,      1.32927,      16.7224,       7.38979,      13.2153,
				0.263297,      6.35234,      22.9426,      9.85329};	
		ions.add(new Ion("Pt2+", tab67));
		
		double[] tab68 = { 30.9612,      1.24813,      15.9829,       6.60834,      13.7348,
				0.16864,      5.92034,      16.9392,      7.39534};	
		ions.add(new Ion("Pt4+", tab68));
		
		double[] tab69 = { 16.8819,       0.4611,      18.5913,        8.6216,      25.5582,
				1.4826,         5.86,      36.3956,      12.0658};	
		ions.add(new Ion("Au", tab69));
		
		double[] tab70 =  { 28.0109,      1.35321,      17.8204,        7.7395,      14.3359,
				0.356752,      6.58077,      26.4043,      11.2299};	
		ions.add(new Ion("Au1+", tab70));
		
		double[] tab71 = { 30.6886,       1.2199,      16.9029,       6.82872,      12.7801,
				0.212867,      6.52354,       18.659,       9.0968};	
		ions.add(new Ion("Au3+", tab71));
		
		double[] tab72 = { 20.6809,        0.545,      19.0417,        8.4484,      21.6575,
				1.5729,       5.9676,      38.3246,      12.6089};	
		ions.add(new Ion("Hg", tab72));
		
		double[] tab73 = { 25.0853,      1.39507,      18.4973,       7.65105,      16.8883,
				0.443378,      6.48216,      28.2262,      12.0205};	
		ions.add(new Ion("Hg1+", tab73));
		
		double[] tab74 = { 29.5641,      1.21152,        18.06,       7.05639,      12.8374,
				0.284738,      6.89912,      20.7482,      10.6268};	
		ions.add(new Ion("Hg2+", tab74));
		
		double[] tab75 = { 31.0617,       0.6902,      13.0637,        2.3576,       18.442,
				8.618,       5.9696,      47.2579,      13.4118};	
		ions.add(new Ion("Pb", tab75));
		
		double[] tab76 = { 21.7886,       1.3366,      19.5682,      0.488383,      19.1406,
				6.7727,      7.01107,      23.8132,      12.4734};	
		ions.add(new Ion("Pb2+", tab76));
		
		double[] tab77 = { 32.1244,      1.00566,      18.8003,       6.10926,      12.0175,
				0.147041,      6.96886,       14.714,      8.08428};	
		ions.add(new Ion("Pb4+", tab77));
		
		double[] tab78 = { 33.3689,        0.704,       12.951,        2.9238,      16.5877,
				8.7937,       6.4692,      48.0093,      13.5782};	
		ions.add(new Ion("Bi", tab78));
		
		double[] tab79 = { 21.8053,       1.2356,      19.5026,       6.24149,      19.1053,
				0.469999,      7.10295,      20.3185,      12.4711};	
		ions.add(new Ion("Bi3+", tab79));
		
		double[] tab80 = { 33.5364,      0.91654,      25.0946,       0.39042,      19.2497,
				5.71414,      6.91555,      12.8285,       6.7994};	
		ions.add(new Ion("Bi5+", tab80));
		
		double[] tab81 = { 17.6142,      1.18865,      12.0144,        11.766,      4.04183,
		      0.204785,      3.53346,      69.7957,      3.75591};	
		ions.add(new Ion("Nb", tab81));
		
		double[] tab82 = {  3.7025,       0.2772,      17.2356,        1.0958,      12.8876,
	        11.004,       3.7429,      61.6584,       4.3875};	
			ions.add(new Ion("Mo", tab82));
		
		
	}	
	
	public static double[] giveParam(String name) {
		double[] param = null;
		for(Ion i : ions) {
			if(i.name.compareTo(name) == 0) {
				param = new double[9];
				param[0] = i.A1;
				param[1] = i.B1;
				param[2] = i.A2;
				param[3] = i.B2;
				param[4] = i.A3;
				param[5] = i.B3;
				param[6] = i.A4;
				param[7] = i.B4;
				param[8] = i.C;
			}
		}
		return param;
	}
}    