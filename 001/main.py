import controller, model
import sys 

DB_filename = 'notes.txt'

main_map = 	{	'1': 'Добавить запись',
				'2': 'Просмотр списка записей',
				'3': 'Поиск',
				'4': 'Просмотр записи',
				'5': 'Выбрать записи по дате',
				'6': 'Изменить запись',
				'7': 'Удалить запись',
				'0': 'Выход'
			}

input_map = 	{	'id': 			['ID', 'auto'],
					'date':			['Дата добавления', 'auto'],
					'title': 		['Заголовок', 'notEmpty', 'не должно быть пустым'],
					'note':			['Заметка', '']
				}


if __name__ == "__main__":
	while True:
		print("="*10 + " ЗАМЕТКИ " + "="*10 + "\n")
		items_count = model.CountItems(DB_filename)
		print(f"Записей в базе: {items_count}\n\n")

		print(model.PrintByTemplateMain(main_map))
		setDo = input("\n\nВыберите действие: ")

		if setDo == '1':
			print("-"*10 + " " + main_map[setDo] + " " + "-"*10 + "\n")
			result = controller.AddItem(input_map, DB_filename)

			if result: print ("Запись успешно добавлена в базу")
			else: print ("Ошибка! Не удалось добавить запись в файл")

		elif setDo == '2':
			print("-"*10 + " " + main_map[setDo] + " " + "-"*10 + "\n")
			if not controller.ReadItems(input_map, DB_filename):
				print ("Ошибка! Невозможно вывести список")

		elif setDo == '3':
			print("-"*10 + " " + main_map[setDo] + " " + "-"*10 + "\n")
			if not controller.SearchItems(input_map, DB_filename):
				print ("Ошибка! Невозможно осуществить поиск")

		elif setDo == '4':
			print("-"*10 + " " + main_map[setDo] + " " + "-"*10 + "\n")
			if not controller.ReadFullNote(DB_filename):
				print ("Ошибка! Невозможно просмотреть заметку")

		elif setDo == '5':
			print("-"*10 + " " + main_map[setDo] + " " + "-"*10 + "\n")
			if not controller.ChooseDate(input_map, DB_filename):
				print ("Ошибка! Невозможно осуществить поиск")

		elif setDo == '6':
			print("-"*10 + " " + main_map[setDo] + " " + "-"*10 + "\n")
			result = controller.EditItem(input_map, DB_filename)

			if result: print ("Запись изменена")
			else: print ("Ошибка! Невозможно изменить запись")

		elif setDo == '7':
			print("-"*10 + " " + main_map[setDo] + " " + "-"*10 + "\n")
			result = controller.DeleteItem(DB_filename)
			
			if result: print ("Запись удалена")
			else: print ("Ошибка! Невозможно удалить запись")

		elif setDo == '0' or setDo == '':
			sys.exit()

		input('\nнажмите Enter...')