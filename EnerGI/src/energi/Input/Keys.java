/*
 * To change this template), choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Input;

/**
 * Enumeration of key constants (mirrored with LWJGL's key constants for means of consistency)
 * @author andrew
 * @version 1.0
 */
public enum Keys
{
	/**
	 * ESC
	 */
	 KEY_ESCAPE(0x01),
	 /**
	  * 1
	  */
	 KEY_1(0x02),
	 /**
	  * 2
	  */
	 KEY_2(0x03),
	 /**
	  * 3
	  */
	 KEY_3(0x04),
	 /**
	  * 4
	  */
	 KEY_4(0x05),
	 /**
	  * 5
	  */
	 KEY_5(0x06),
	 /**
	  * 6
	  */
	 KEY_6(0x07),
	 /**
	  * 7
	  */
	 KEY_7(0x08),
	 /**
	  * 8
	  */
	 KEY_8(0x09),
	 /**
	  * 9
	  */
	 KEY_9(0x0A),
	 /**
	  * 0
	  */
	 KEY_0(0x0B),
	 /**
	  * Main keyboard -
	  */
	 KEY_MINUS(0x0C),
	 /**
	  * =
	  */
	 KEY_EQUALS(0x0D),
	 /**
	  * Backspace
	  */
	 KEY_BACK(0x0E),
	 /**
	  * Tab
	  */
	 KEY_TAB(0x0F),
	 KEY_Q(0x10),
	 KEY_W(0x11),
	 KEY_E(0x12),
	 KEY_R(0x13),
	 KEY_T(0x14),
	 KEY_Y(0x15),
	 KEY_U(0x16),
	 KEY_I(0x17),
	 KEY_O(0x18),
	 KEY_P(0x19),
	 /**
	  * (
	  */
	 KEY_LBRACKET(0x1A),
	 /**
	  * )
	  */
	 KEY_RBRACKET(0x1B),
	 /**
	  * Return/Enter
	  */
	 KEY_RETURN(0x1C),
	 /**
	  * Left Ctrl
	  */
	 KEY_LCONTROL(0x1D),
	 KEY_A(0x1E),
	 KEY_S(0x1F),
	 KEY_D(0x20),
	 KEY_F(0x21),
	 KEY_G(0x22),
	 KEY_H(0x23),
	 KEY_J(0x24),
	 KEY_K(0x25),
	 KEY_L(0x26),
	 /**
	  * :
	  */
	 KEY_SEMICOLON(0x27),
	 /**
	  * '
	  */
	 KEY_APOSTROPHE(0x28),
	 /**
	  * Accent grave
	  */
	 KEY_GRAVE(0x29),
	 /**
	  * Left shift
	  */
	 KEY_LSHIFT(0x2A),
	 /**
	  * \
	  */
	 KEY_BACKSLASH(0x2B),
	 KEY_Z(0x2C),
	 KEY_X(0x2D),
	 KEY_C(0x2E),
	 KEY_V(0x2F),
	 KEY_B(0x30),
	 KEY_N(0x31),
	 KEY_M(0x32),
	 /**
	  * ,
	  */
	 KEY_COMMA          (0x33),
	 /**
	  * .
	  */
	 KEY_PERIOD         (0x34),
	 /**
	  * /
	  */
	 KEY_SLASH          (0x35),
	 /**
	  * Right shift
	  */
	 KEY_RSHIFT         (0x36),
	 /**
	  * * on keypad
	  */
	 KEY_MULTIPLY       (0x37),
	 /**
	  * Left alt
	  */
	 KEY_LMENU          (0x38),
	 /**
	  * Spacebar
	  */
	 KEY_SPACE          (0x39),
	 /**
	  * Caps lock
	  */
	 KEY_CAPITAL        (0x3A),
	 KEY_F1             (0x3B),
	 KEY_F2             (0x3C),
	 KEY_F3             (0x3D),
	 KEY_F4             (0x3E),
	 KEY_F5             (0x3F),
	 KEY_F6             (0x40),
	 KEY_F7             (0x41),
	 KEY_F8             (0x42),
	 KEY_F9             (0x43),
	 KEY_F10            (0x44),
	 /**
	  * Num lock
	  */
	 KEY_NUMLOCK        (0x45),
	 /**
	  * Scroll lock
	  */
	 KEY_SCROLL         (0x46),
	 KEY_NUMPAD7        (0x47),
	 KEY_NUMPAD8        (0x48),
	 KEY_NUMPAD9        (0x49),
	 /**
	  * - on keypad
	  */
	 KEY_SUBTRACT       (0x4A),
	 KEY_NUMPAD4        (0x4B),
	 KEY_NUMPAD5        (0x4C),
	 KEY_NUMPAD6        (0x4D),
	 /**
	  * + on keypad
	  */
	 KEY_ADD            (0x4E),
	 KEY_NUMPAD1        (0x4F),
	 KEY_NUMPAD2        (0x50),
	 KEY_NUMPAD3        (0x51),
	 KEY_NUMPAD0        (0x52),
	 /**
	  * . on keypad
	  */
	 KEY_DECIMAL        (0x53),
	 KEY_F11(0x57),
	 KEY_F12(0x58),
         
         /////////////////////////////////////////
         // Non standard keys //
         /////////////////////////////////////////
	 KEY_F13 (0x64), /*      (NEC PC98) */
	 KEY_F14(0x65), /*      (NEC PC98) */
	 KEY_F15(0x66), /*      (NEC PC98) */
	 KEY_KANA(0x70), /* (Japanese keyboard)            */
	 KEY_CONVERT        (0x79), /* (Japanese keyboard)            */
	 KEY_NOCONVERT      (0x7B), /* (Japanese keyboard)            */
	 KEY_YEN            (0x7D), /* (Japanese keyboard)            */
	 KEY_NUMPADEQUALS   (0x8D), /*(on numeric keypad (NEC PC98) */
	 KEY_CIRCUMFLEX     (0x90), /* (Japanese keyboard)            */
	 KEY_AT             (0x91), /*      (NEC PC98) */
	 KEY_COLON          (0x92), /*      (NEC PC98) */
	 KEY_UNDERLINE      (0x93), /*      (NEC PC98) */
	 KEY_KANJI          (0x94), /* (Japanese keyboard)            */
	 KEY_STOP           (0x95), /*      (NEC PC98) */
	 KEY_AX             (0x96), /*      (Japan AX) */
	 KEY_UNLABELED      (0x97), /*         (J3100) */
	 KEY_NUMPADENTER    (0x9C), /* Enter on numeric keypad */
         /////////////////////////////////////////////////////////
         // Special Keys//
         ////////////////////////////////////////////////////////
	 /**
	  * Right ctrl
	  */
	 KEY_RCONTROL       (0x9D),
	 KEY_NUMPADCOMMA    (0xB3), /* ), on numeric keypad (NEC PC98) */
	 /**
	  * / on keypad
	  */
	 KEY_DIVIDE         (0xB5), /* / on numeric keypad */
	 KEY_SYSRQ          (0xB7),
	 /**
	  * Right alt
	  */
	 KEY_RMENU          (0xB8), /* right Alt */
	 KEY_PAUSE          (0xC5), /* Pause */
	 KEY_HOME           (0xC7), /* Home on arrow keypad */
	 KEY_UP             (0xC8), /* UpArrow on arrow keypad */
	 KEY_PRIOR          (0xC9), /* PgUp on arrow keypad */
	 KEY_LEFT           (0xCB), /* LeftArrow on arrow keypad */
	 KEY_RIGHT          (0xCD), /* RightArrow on arrow keypad */
	 KEY_END            (0xCF), /* End on arrow keypad */
	 KEY_DOWN           (0xD0), /* DownArrow on arrow keypad */
	 KEY_NEXT           (0xD1), /* PgDn on arrow keypad */
	 KEY_INSERT         (0xD2), /* Insert on arrow keypad */
	 KEY_DELETE         (0xD3), /* Delete on arrow keypad */
	 /**
	  * Left Windows/Apple key
	  */
	 KEY_LMETA           (0xDB), /* Left Windows/Option key */
	 /**
	  * Right Windows/Apple Key
	  */
	 KEY_RMETA           (0xDC), /* Right Windows/Option key */
	 /**
	  * Application key (non-standard)
	  */
	 KEY_APPS           (0xDD), /* AppMenu key */
	 /**
	  * Power key (non-standard)
	  */
	 KEY_POWER          (0xDE),
	 /**
	  * Sleep key (non-standard)
	  */
	 KEY_SLEEP          (0xDF);
	 private int id;
	 
	 private Keys(int id)
	 {
		 this.id = id;
	 }
	 
	 /**
	  * Returns the integer ID of a key
	  * @return An integer representing a key on a keyboard
	  */
	 int getID()
	 {
		 return id;
	 }
}
