package com.fifedu.rxfiflibrary.events;

/**
 * 事件集中定义
 * @author weidingqiang
 */
public class BaseEvents {
	
	private Object data;
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	private int type;

	public int getType() {
		return type;
	}

    public void setType(int type) {
        this.type = type;
    }

    public BaseEvents(int type) {
		super();
		this.type = type;
	}
	
	public BaseEvents(int type,Object data) {
        super();
        this.type = type;
        this.data = data;
    }
	
}
