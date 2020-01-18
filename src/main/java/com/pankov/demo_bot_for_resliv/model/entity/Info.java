package com.pankov.demo_bot_for_resliv.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "info", schema = "info_storage")
public class Info extends BaseEntity<Long> {

    @Column(name = "city", length = 128, unique = true)
    private String cityName;

    @Column(name = "description", length = 1024)
    private String description;
}
