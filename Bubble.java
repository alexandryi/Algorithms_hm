package sort;

import java.util.Arrays;

public class Bubble {

	public static int[] bubble(int[] arr) {
		int sortedIndex = arr.length;
		int numberOfSwap = 1;
		while (numberOfSwap > 0) {
			numberOfSwap = 0;
			for (int i = 0; i < sortedIndex - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					numberOfSwap += 1;
				}
			}
			sortedIndex -= 1;
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 814, 250, -619, 724, 847, -57, 684, 567, -576, -140, 357, -640, -982, 142, 966, -847, 85, -131, -484, 106, -332, 988, -712, 542, 618, -907, 991, -235, -840, 945, 949, -829, 369, 410, 495, 908, 542, 851, 813, 515, -47, 817, -316, 346, -659, -633, 396, 963, -177, 676, 138, -975, -777, 622, 692, 950, -77, -542, -602, -645, 80, 913, 719, -294, -155, 845, -163, 468, 928, -924, -698, -226, 878, -742, -432, 640, -944, -560, 700, -393, 839, -5, -708, -915, -779, -70, -871, 691, 464, -758, -279, 166, -488, 363, 756, -360, 829, 545, 1000, 663, 1000, -210, 297, 724, -612, -389, -155, -298, -999, 904, 310, -343, 485, 675, 521, -591, 924, -728, -944, -729, 274, 485, -458, 83, 156, -470, 604, 554, -86, -592, 799, 196, 216, 957, -475, -434, 343, -14, -52, -82, 497, 525, -847, -64, -488, -459, 356, 273, 840, 612, 350, -908, 453, 304, 163, 891, -652, 445, 378, 946, 952, -806, -367, -748, -338, 555, -132, 985, 560, -169, -776, -423, 371, 967, 875, -249, 308, 892, -905, -248, 13, 741, -270, 691, -408, 412, -882, 833, -271, -796, -549, 301, 961, 495, -849, -501, -284, -254, 459, 202, 934, 638, -152, -35, 156, 93, -596, 973, 761, -177, 362, -89, -504, 620, 441, 103, 378, 194, 377, -591, -378, -112, 210, -866, 30, 858, 645, -746, 200, 105, 946, -866, 626, 392, 641, -846, -753, -862, 260, -356, 360, 594, -765, -897, 751, -212, -602, 798, 919, 437, -794, -306, -277, -186, -297, -944, -787, -227, -146, 848, -350, 187, -46, 901, 864, -980, 648, 476, 256, -54, 19, 634, -118, 42, 55, 632, -974, -895, 421, -337, 662, -754, 800, -824, 340, -781, 935, -907, 514, -636, 772, -113, 205, 476, -117, -382, 575, -769, -386, 843, -459, -516, -751, 442, 236, 536, 776, -331, 858, -315, -647, -215, -317, -694, -37, -410, -645, -886, -896, 650, 311, -498, 525, -354, -337, -91, 157, -639, -435, 964, 682, -707, 962, 338, 723, -682, -913, -1, 560, -633, 811, -319, 135, 180, -743, -314, 619, -196, -127, 371, 842, -466, 773, 121, 640, -151, -125, 87, -143, -733, -62, 966, -534, -56, 205, -228, -702, -365, 768, 846, -97, 388, -875, -955, 75, 933, 816, -571, -824, -874, 789, -38, -594, 272, -415, -799, -306, 242, 639, -563, 31, 394, -684, 476, -302, -896, -860, 110, 455, -190, 130, -545, -576, -182, 425, -876, -97, 224, 445, 47, -424, -766, 270, -15, 7, 836, -98, -202, -268, 521, 927, -877, -874, 446, -431, -967, 178, 724, 510, -87, 321, 691, 767, 18, 440, -945, -25, 417, 455, -660, 700, -930, -333, -603, 901, 657, 593, 295, -676, 282, -254, -408, 130, 281, 632, 643, -422, 917, -751, -460, 876, -46, 328, -708, -223, 698, -515, 392, 99, 476, 15, -976, 720, -757, 362, -885, 790, 733, -830, -192, 63, -749, -54, -498, -929, -218, -883, 717, 732, -338, 140, -790, -787, -46, -42, 828, 470, 114, -602, 791, -17, 21, -264, -550, -99, -466, 297, -290, -744, 950, 719, -505, 940, -772, -728, -757, -11, 726, 323, -702, 576, 71, -578, -680, 207, 95, -440, 790, 5, 49, -848, -287, 170, -670, 809, 872, -453, 434, 989, -794, 540, -760, 894, -874, 429, -619, 866, -764, 864, 287, -418, 677, 394, 738, 581, 657, 25, 596, -912, -15, -260, 238, 74, -286, -467, -962, 884, 996, -58, -137, -82, 565, -262, 520, -893, -677, 355, -940, -246, -858, 954, -889, 721, 395, -206, -923, 629, 553, 889, 313, 185, -213, 910, 916, -130, -31, 204, -489, -801, -320, 73, 203, 479, 911, 639, -277, 775, -976, -12, 777, -961, 761, 516, -603, -193, 966, 897, -501, 552, -513, 249, 708, 296, -802, -702, 502, 768, 68, -242, 38, -760, 902, -53, 942, 188, -697, -707, 283, 172, -377, -802, -278, 377, 459, 219, 915, 284, -563, -900, 939, 497, 595, 39, -521, -892, 942, -440, -319, -667, -954, -184, 18, 434, -475, -517, -179, 229, 188, -277, 111, -881, -833, 580, -47, 22, 16, -931, -465, 180, 670, 131, 617, 558, -821, 723, -472, -862, -919, 690, -799, -603, -61, -131, -128, -783, -633, 944, -644, -891, -591, 97, 456, -129, 644, 741, -451, 415, 232, 558, 658, 139, 239, -457, 12, -397, 267, 1, -166, 42, 170, -596, -432, 81, 658, 829, -558, -761, 188, 22, -850, -308, -444, -987, 596, 533, -702, 737, -863, 467, -509, 427, -191, -480, 959, -950, 34, -739, 716, 469, -235, 145, 210, 909, -687, -281, -334, 486, 339, 264, 459, -656, 420, -756, -115, 749, 964, 916, 104, -328, 276, -799, 262, 530, -674, -672, -265, 138, -222, -544, -497, -452, 428, 262, -612, -345, -801, 152, 961, 126, -469, -265, 248, 955, 843, -840, -487, 630, -121, 470, -178, 36, 586, 911, -642, 262, -654, -494, 410, -643, 49, -804, -620, -801, 583, 928, -283, 350, -807, -331, -43, 594, -117, -957, 33, 191, -525, 618, 535, 781, 213, -516, -996, -359, -184, 12, -660, 578, 389, 428, -309, 958, -888, -307, 641, -423, 494, 71, 179, -404, 481, -108, -813, -286, 439, -309, 67, -854, -281, -939, 301, 309, 60, -568, -500, -410, -263, -101, 867, -248, -707, 39, -758, 224, -538, -800, -975, -39, 383, 788, 733, -701, 706, -841, -186, -280, 710, -119, 678, 631, 482, 182, 822, 174, 579, 586, 368, 313, -947, 823, 619, 530, -294, -9, 744, 646, -839, -122, -738, -167, 739, -234, -944, -9, 396, -494, 684, 933, 427, -972, -263, -802, -871, -754, -158, -814, -42, 415, 577, 451, -740, 3, -976, 457, 528, 406, 835, -708, -599, -873, 720, -526, -64, 360, 944, -283, -2, -837, -433, -618, -698, 301, -881, -909, 955, 18, 108, -443, -939, 96, 930, -935, -524, -667, -881, -81, -761, 64, 926, 896, -686, -739, 364, 730, 219, 513, 462, 920, -740, -4, 421, -392, 653, -932, -100, 627, 748, -560, 558, -321, -478, 955, -226, -649, -711, -684, 105, -233, -453, 570, 926 };

		System.out.println(Arrays.toString(arr));// income
		long startTime = System.currentTimeMillis();
		long startTime1 = System.nanoTime();
		System.out.println(Arrays.toString(bubble(arr)));// outcome
		long endTime = System.currentTimeMillis();
		long endTime1 = System.nanoTime();
		System.out.println("Время выполнения: " + (endTime - startTime) + " миллисекунд");
		System.out.println("Время выполнения: " + (endTime1 - startTime1) + " наносекунд");
		
		
	}

}
