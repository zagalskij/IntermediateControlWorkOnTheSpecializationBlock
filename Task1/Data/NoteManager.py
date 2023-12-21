import dataclasses
from datetime import datetime
from .Note import Note
import os
import json
class NoteManager:
    def __init__(self, file_path='note.json'):
        self.file_path = file_path
        self.notes = []
        self.load_notes()
        self.last_note_id = max([note.note_id for note in self.notes], default=0)

    def load_notes(self):
        if os.path.exists(self.file_path):
            with open(self.file_path,"r") as file:
                data = json.load(file)
                self.notes = [Note(**note_data) for note_data in data]
            
    def save_notes(self):
           data = [dataclasses.asdict(note) for note in self.notes]
           with open(self.file_path, 'w') as file:
            json.dump(data, file)

    def add_note(self, title, body):
        timestamp = datetime.now().strftime('%d-%m-%Y %H:%M:%S')
        self.last_note_id += 1
        new_note = Note(self.last_note_id, title, body, timestamp)
        self.notes.append(new_note)
        self.save_notes()
        print(f"Note added: {new_note.title}")
    
    def list_notes(self, filter_date=None):
        filtered_notes = self.notes
        if filter_date:
            filtered_notes = [note for note in self.notes if note.timestamp.startswith(filter_date)]
            return filtered_notes
        return self.notes
      

    def edit_note(self, note_id, title, body):
        if 1 <= note_id <= self.last_note_id:
            for note in self.notes:
                if note.note_id == note_id: 
                    note.title = title       
                    note.body = body
                    note.timestamp = datetime.now().strftime('%d-%m-%Y %H:%M:%S')
                    self.save_notes()
                    return note_id
            

    def delete_note(self, note_id):
        if 1 <= note_id <= self.last_note_id:
            for note in self.notes:
                if note.note_id == note_id:
                    self.notes.remove(note)
                    self.save_notes()
                    return note
       