from datetime import datetime


class NoteView:

    def display_notes(self, notes):
        for note in notes:
            formatted_timestamp = datetime.strptime(note.timestamp, '%d-%m-%Y %H:%M:%S').strftime('%d-%m-%Y %H:%M:%S')
            print(f"{note.note_id}. {note.title} - {formatted_timestamp}")

    def display_message(self, message):
        print(message)