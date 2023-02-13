package com.educandoweb.course.enums;

public enum OrderStatus {
<<<<<<< HEAD

=======
>>>>>>> 7627677da9dbc96005fe04049ef5662ac2650fe3
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

<<<<<<< HEAD
    private OrderStatus(int code){
        this.code=code;
    }
    public int getCode(){
        return code;
    }
    public static OrderStatus valueOf(int code){
        for(OrderStatus value : OrderStatus.values()){
            if(value.getCode() == code){
                return value;
            }

        }
        throw new IllegalArgumentException("Invalid OrderStatus Code")
    }


=======
    private OrderStatus (int code){
        this.code=code;
    }

    public int getCode() {
        return code;
    }
    public static OrderStatus valueOf(int code){
        for (OrderStatus value : OrderStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Enter a valid OrderStatus code");
    }
>>>>>>> 7627677da9dbc96005fe04049ef5662ac2650fe3
}
