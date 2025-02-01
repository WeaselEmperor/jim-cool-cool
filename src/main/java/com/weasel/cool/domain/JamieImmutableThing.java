package com.weasel.cool.domain;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.SerializationUtils;

import java.time.Instant;
import java.util.List;

//TODO: write test spec for this class (...time consuming...)

// make class final so that it can't be extended
public final class JamieImmutableThing {

    // make all fields private (otherwise object references are exposed, leaving JamieCoolThing, List, Instant open to internal modification
    // make all fields final, so that their values can't be changed once they're set
    private final JamieCoolThing jamieCoolThing;
    private final List<CoolnessRating> coolnessRatings;
    private final int howManyBowlsOfCongee;
    private final Instant coolTime;

    public JamieImmutableThing(final JamieCoolThing jamieCoolThing, final List<CoolnessRating> coolnessRatings,
                               final int howManyBowlsOfCongee, final Instant coolTime) {
        // since JamieCoolThing is not a final class, we don't want to call .clone() on it here, cos it could be maliciously overridden,
        // so we create a new JamieCoolThing from the given one.
        this.jamieCoolThing = new JamieCoolThing(jamieCoolThing.getName(), jamieCoolThing.getCoolnessRating());

        // create a null-safe *copy* of the given list
        this.coolnessRatings = Lists.newArrayList(CollectionUtils.emptyIfNull(coolnessRatings));

        // is a scalar/primitive value, so simple assignment is fine (since it's already being passed in as a value copy)
        this.howManyBowlsOfCongee = howManyBowlsOfCongee;

        // cloning feels a bit dirty anyway tbh, but since Instant is a final class (and implements Serializable), we can
        // pretty safely use SerializationUtils to clone it here
        this.coolTime = SerializationUtils.clone(coolTime);
    }

    public JamieCoolThing getJamieCoolThing() {
        // return a Defensive copy - JamieCoolThing is not immutable, so if we want to keep JamieImmutableThing immutable,
        // we need to return copies of any mutable elements
        return new JamieCoolThing(jamieCoolThing.getName(), jamieCoolThing.getCoolnessRating());
    }

    public List<CoolnessRating> getCoolnessRatings() {
        // return a Defensive Copy, so nobody can alter the contents of this.coolnessRatings.
        // Alternatively, you could do a 'return Collections.unmodifiableList(coolnessRatings)'; defensive copy is arguably slightly
        // more 'encapsulative', cos the reference to the underlying collection is hidden, but i think either is probably fine.
        return Lists.newArrayList(coolnessRatings);
    }

    public int getHowManyBowlsOfCongee() {
        return howManyBowlsOfCongee;
    }


    public Instant getCoolTime() {
        // still need to confirm - i think this is safer; it seems like calling .plus(_) on an instant does modify its contents
        // but not 100% sure, haven't checked in detail
        return SerializationUtils.clone(coolTime);
    }

    // no setters
}
