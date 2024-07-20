package com.project.mingle.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomVO {
    private int room_no;
    private String user_id;
    private String room_name;
}
