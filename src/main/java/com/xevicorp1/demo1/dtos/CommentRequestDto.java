// DATA TRANSFER OBJECT --> EL QUE VOLEM REBRE I VOLEM ENVIAR / ENTRAR I SORTIR DE L'API I DELS SERVEIS
// S'assemblen als models però defineixen la forma que tindrà el JSON que surt o que entra
// És necessari fer data transfer per poder-la guardar

package com.xevicorp1.demo1.dtos;

import lombok.Data;

@Data
public class CommentRequestDto {
    private String comment;
    private Long itemId;
}
