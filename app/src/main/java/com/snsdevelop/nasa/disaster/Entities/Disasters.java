package com.snsdevelop.nasa.disaster.Entities;

import java.util.List;

public class Disasters {
    private List<Disaster> Disasters;

    public List<Disaster> GetDisasters() {
        return Disasters;
    }

    public void SetDisasters(List<Disaster> disasters) {
        Disasters = disasters;
    }
}
