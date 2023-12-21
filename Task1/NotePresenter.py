import NoteView
from Data import NoteManager
class NotePresenter: 
    def __init__(self):
        self.view = NoteView.NoteView()
        self.note_manager = NoteManager.NoteManager()

    def run(self):
        while True:
            print("\nOptions:")
            print("1. Add Note")
            print("2. List Notes")
            print("3. Edit Note")
            print("4. Delete Note")
            print("5. Exit")

            choice = input("Enter your choice: ")

            if choice == '1':
                title = input("Enter note title: ")
                body = input("Enter note body: ")
                self.note_manager.add_note(title, body)

            elif choice == '2':
                filter_date = input("Enter date for filtering (optional, format: DD-MM-YYYY): ")
                self.view.display_notes(self.note_manager.list_notes(filter_date))

            elif choice == '3':
                note_id = int(input("Enter note ID to edit: "))
                title = input("Enter new title: ")
                body = input("Enter new body: ")
                edited_note = self.note_manager.edit_note(note_id, title, body)
                if edited_note:
                    self.view.display_message(f"Note {note_id} edited successfully.")
                else:
                    self.view.display_message(f"Note with ID {note_id} not found.")

            elif choice == '4':
                note_id = int(input("Enter note ID to delete: "))
                deleted_note = self.note_manager.delete_note(note_id)
                if deleted_note:
                    self.view.display_message(f"Note {note_id} deleted: {deleted_note.title}")
                else:
                    self.view.display_message(f"Note with ID {note_id} not found.")

            elif choice == '5':
                self.view.display_message("Exiting the program.")
                break

            else:
                self.view.display_message("Invalid choice. Please enter a valid option.")