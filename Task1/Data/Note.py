from dataclasses import dataclass

@dataclass
class Note:
    note_id: int
    title: str
    body: str
    timestamp: str 
