def AddItemToDB(item: list, DB_name: str):
	with open(DB_name, 'a', encoding='UTF-8') as file:
		if type(item) is list:
			file.writelines(str(item)[1:-1] + "\n")
			return True
	return False


def SolveID(DB_name: str):
	try:
		with open(DB_name, 'r', encoding='UTF-8') as file:
			res_list = []
			for line in file:
				a = line.split(", ")
				res_list.append(a[0])
				pass
			res_list.sort()
			new_id = int(res_list[-1]) + 1
			return new_id
	except:
		return 0


def FindInDB(DB_name: str, query: str):
	try:
		res_list = []
		with open(DB_name, 'r', encoding='UTF-8') as file:
			for line in file:
				if query.lower() in line.lower(): 
					res_list.append(line)
		if len(res_list) > 0:
			return res_list
		else:
			return False
	except:
		return False


def SelectByDate(DB_name: str, query: str):
	try:
		res_list = []
		with open(DB_name, 'r', encoding='UTF-8') as file:
			for line in file:
				a = line.split(", ")
				b = query.split("-")
				queryFormat = ""
				for miniB in b:
					queryFormat += str(int(miniB)) + "-"
				if a[3][1:-2] == queryFormat[:-1]:
					res_list.append(line)
		if len(res_list) > 0:
			return res_list
		else:
			return False
	except:
		return False


def CountItems(DB_name: str):
	try:
		count = 0
		with open(DB_name, 'r', encoding='UTF-8') as file:
			for line in file:
				count += 1
			return count
	except:
		return 0


def PrintByTemplateMain(main_dict: dict):
	output_string = ''
	for key in main_dict.keys():
		output_string += key + ": " + main_dict[key] + "\n"
	return output_string


def PrintByTemplateItem(item_str: str):
	item = item_str.replace("\n", "").split(", ")
	return(f'[{item[0]}]: ({item[3][1:-1]}) {item[1][1:-1]}')


def PrintByTemplateFullItem(DB_filename: str, id_item: int):
	item_str = ReadOneItem(DB_filename, id_item)
	item = item_str.replace("\n", "").split(", ")
	return(f'ID: {item[0]}\nДата добавления/изменения: {item[3][1:-1]}\nЗаголовок: {item[1][1:-1]}\nТекст заметки: {item[2][1:-1]}')


def PrintByTemplateMainMap(input_map: dict):
	output_string = ''
	for key in input_map.keys():
		if key == "id": output_string += "[" + input_map[key][0] + "]: "
		elif key == "date": output_string += "\t" + input_map[key][0] + "\t"
		elif key == "title": output_string += "\t" + input_map[key][0] + "\t"
		else:
			output_string += "" # input_map[key][0] + "\t"
	return output_string + "\n"


def ReadItemsFromDB(DB_name: str):
	try:
		with open(DB_name, 'r', encoding='UTF-8') as file:
			data = file.readlines()
		return data
	except:
		return False


def ReadOneItem(DB_name: str, ID: int):
	items = ReadItemsFromDB(DB_name)
	if items:
		for item in items:
			a = item.split(", ")
			if int(a[0]) == ID:
				return item
	else:
		return False


def DeleteByID(DB_name: str, ID: int):
	items = ReadItemsFromDB(DB_name)
	if items:
		try:
			with open(DB_name, 'w', encoding='UTF-8') as file:
				for item in items:
					a = item.split(", ")
					if int(a[0]) != ID:
						file.write(item)
			return True	
		except:
			return False