package eu.mszulc.model.Materials;

import eu.mszulc.model.DefaultModel;

import javax.persistence.*;

/**
 * Created by master on 09/10/16.
 */
@Entity
@Table(name = "hops")
public class Hop extends DefaultModel {
    private String name;

    private Long alphaPercent;

    @Column(precision=15, scale=7)
    private Float amount; //in grams

    private enum HopType {
        LEAF, PELLET, PLUG
    }

    @Enumerated(EnumType.STRING)
    private HopType form;

    private enum UseType {
        MASH, FIRST_WORT, BOIL, AROMA, DRY_HOP
    }

    @Enumerated(EnumType.STRING)
    private UseType hopUse;

    private Long time;//in seconds

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAlphaPercent() {
        return alphaPercent;
    }

    public void setAlphaPercent(Long alphaPercent) {
        this.alphaPercent = alphaPercent;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public HopType getForm() {
        return form;
    }

    public void setForm(HopType form) {
        this.form = form;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public UseType getHopUse() {
        return hopUse;
    }

    public void setHopUse(UseType hopUse) {
        this.hopUse = hopUse;
    }

    @Override
    public String toString() {
        return String.format(
                "Hop[id=%d, name='%s', alphaPercent='%s', amount='%s', form='%s', hopUse='%s', time='%s']",
                getId(), getName(), getAlphaPercent(), getAmount(), getForm(), getHopUse(), getTime());
    }
}
