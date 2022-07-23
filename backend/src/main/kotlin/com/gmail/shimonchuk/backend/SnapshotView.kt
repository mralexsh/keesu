package com.gmail.shimonchuk.backend

data class SnapshotView(
    val snapshots: HashMap<String, MutableList<Snapshot>>
)