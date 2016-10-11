package eu.mszulc.model.Materials;

import eu.mszulc.model.DefaultModel;

import javax.persistence.*;

/**
 * Created by master on 09/10/16.
 */
@Entity
@Table(name = "fermentables")
public class Fermentables extends DefaultModel {
    private String name;

    private enum FermentablesType {
        GRAIN, SUGAR, EXTRACT, DRY_EXTRACT, ADJUNCT
    }

    @Enumerated(EnumType.STRING)
    private FermentablesType form;

    @Column(precision=15, scale=7)
    private Float amount; //in grams

    private Boolean mashed;

    private Boolean lateAddition;
    @Column(precision=15, scale=7)
    private Float yield;
    
    @Column(precision=15, scale=7)
    private Float color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FermentablesType getForm() {
        return form;
    }

    public void setForm(FermentablesType form) {
        this.form = form;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Boolean getMashed() {
        return mashed;
    }

    public void setMashed(Boolean mashed) {
        this.mashed = mashed;
    }

    public Boolean getLateAddition() {
        return lateAddition;
    }

    public void setLateAddition(Boolean lateAddition) {
        this.lateAddition = lateAddition;
    }

    @Override
    public String toString() {
        return String.format(
                "Fermentables[id=%d, name='%s' ,form='%s', mashed='%s' lateAddition='%s' yield='%s' color='%s']",
                getId(), getName());
    }
}
