package org.jeecg.modules.bzl.doman;

import lombok.Data;

/**
 * @description:
 * @author: bzl
 * @date: 2022年10月09日 9:25
 */
@Data
public class Card {
private int id;
private String title;
private int count;
private double percent;
private String color;
private int userId;
}
