package com.meng.TaiHunDanmaku.control;

import java.util.*;

public class Replay {

	public ArrayList<Byte> data=new ArrayList<>(262143);
	public byte[] dataArray;
	public static final short headLength=16;
	public int dataPointer=0;

	public static final byte typeByte=0;
	public static final byte typeShort=1;
	public static final byte typeInt=2;
	public static final byte typeLong=3;
	public static final byte typeFloat=4;
	public static final byte typeDouble=5;
	public static final byte typeString=6;
	public static final byte typeBoolean=7;

	public static Replay encode(long seed) {
		return new Replay(seed);
	}

	public static Replay decode(byte[] bytes) {
		return new Replay(bytes);
	}

	private Replay(long seed) {
		//length(4) headLength(2) version(2) seed(8)
		writeByteDataIntoArray(BitConverter.getBytes(0));
		writeByteDataIntoArray(BitConverter.getBytes(headLength));
		writeByteDataIntoArray(BitConverter.getBytes((short)1));
		writeByteDataIntoArray(BitConverter.getBytes(seed));
	}   

	private Replay(byte[] pack) {
		dataArray = pack;
		dataPointer = headLength;
	} 

	public byte[] getData() {
		byte[] retData=new byte[data.size()];
		for (int i=0;i < data.size();++i) {
			retData[i] = data.get(i);
		}
		byte[] len=BitConverter.getBytes(retData.length);
		retData[0] = len[0];
		retData[1] = len[1];
		retData[2] = len[2];
		retData[3] = len[3];
		dataArray = retData;
		return retData;
	}

	public int getLength() {
		return BitConverter.toInt(dataArray, 0);
	}  

	public short getHeadLength() {
		return BitConverter.toShort(dataArray, 4);
	}

	public short getVersion() {
		return BitConverter.toShort(dataArray, 6);
	}

	public long getSeed() {
		return BitConverter.toLong(dataArray, 8);
	}

	private Replay writeByteDataIntoArray(byte... bs) {
		for (byte b:bs) {
			data.add(b);
			++dataPointer;
		}
		return this;
	}

	public Replay write(byte b) {
		writeByteDataIntoArray(typeByte);
		writeByteDataIntoArray(b);
		return this;
	}

	public Replay write(short s) {
		writeByteDataIntoArray(typeShort);
		writeByteDataIntoArray(BitConverter.getBytes(s));
		return this;
	}

	public Replay write(int i) {
		writeByteDataIntoArray(typeInt);
		writeByteDataIntoArray(BitConverter.getBytes(i));
		return this;
	}

	public Replay write(long l) {
		writeByteDataIntoArray(typeLong);
		writeByteDataIntoArray(BitConverter.getBytes(l));
		return this;
	}

	public Replay write(float f) {
		writeByteDataIntoArray(typeFloat);
		writeByteDataIntoArray(BitConverter.getBytes(f));
		return this;
	}

	public Replay write(double d) {
		writeByteDataIntoArray(typeDouble);
		writeByteDataIntoArray(BitConverter.getBytes(d));
		return this;
	}

	public Replay write(String s) {
		writeByteDataIntoArray(typeString);
		byte[] StringBytes = BitConverter.getBytes(s);
		write(StringBytes.length);
		writeByteDataIntoArray(StringBytes);
		return this;
	}

	public Replay write(boolean b) {
		writeByteDataIntoArray(typeBoolean);
		writeByteDataIntoArray(b ?(byte)1: (byte)0);
		return this;
	}

	public byte readByte() {
		if (dataArray[dataPointer++] == typeByte) {
			return dataArray[dataPointer++];
		}
		throw new RuntimeException("not a byte number");
	}

	public short readShort() {
		if (dataArray[dataPointer++] == typeShort) {
			short s = BitConverter.toShort(dataArray, dataPointer);
			dataPointer += 2;
			return s;
		}
		throw new RuntimeException("not a short number");
	}

	public int readInt() {
		if (dataArray[dataPointer++] == typeInt) {
			int i= BitConverter.toInt(dataArray, dataPointer);
			dataPointer += 4;
			return i;
		}
		throw new RuntimeException("not a int number");
	}

	public long readLong() {
		if (dataArray[dataPointer++] == typeLong) {
			long l= BitConverter.toLong(dataArray, dataPointer);
			dataPointer += 8;
			return l;
		}
		throw new RuntimeException("not a long number");
	}

	public float readFloat() {
		if (dataArray[dataPointer++] == typeFloat) {
			float f = BitConverter.toFloat(dataArray, dataPointer);
			dataPointer += 4;
			return f;
		}
		throw new RuntimeException("not a float number");
	}

	public double readDouble() {
		if (dataArray[dataPointer++] == typeDouble) {
			double d = BitConverter.toDouble(dataArray, dataPointer);
			dataPointer += 8;
			return d;
		}
		throw new RuntimeException("not a double number");
	}

	public String readString() {
		try {
			if (dataArray[dataPointer++] == typeString) {
				int len = readInt();
				String s = BitConverter.toString(dataArray, dataPointer, len);
				dataPointer += len;
				return s;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
		return null;
	}

	public boolean readBoolean() {
		if (dataArray[dataPointer++] == typeBoolean) {
			return dataArray[dataPointer++] == 1;
		}
		throw new RuntimeException("not a booleanean value at " + dataPointer);
	}

	public boolean hasNext() {
		return dataPointer != dataArray.length;
	}
}

