/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        storage = null;
    }

    void save(Resume r) {
        for (Resume resumeFromStorage : storage) {
            if (resumeFromStorage != null) {
                resumeFromStorage = r;
            }
        }
    }

    Resume get(String uuid) {
        Resume uuidGet = null;
        try {
            for (Resume resumeFromStorage : storage) {
                if (resumeFromStorage.equals(uuid)) {
                    uuidGet = resumeFromStorage;
                }
            }
        } catch (Exception ex) {
            System.out.println("искомое резюме отсутсвует");
        }
        return uuidGet;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length - 1; i++) {
            if (storage[i].equals(uuid)) {
                storage[i] = storage[i + 1];
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        Resume[] resumeNotNull = null;
        try {
            for (int i = 0; i < storage.length; i++) {
                if (storage[i] != null) {
                    resumeNotNull[i] = storage[i];
                }
            }
        } catch (Exception ex) {
            System.out.println("база резюме пустая!");
        }
        return resumeNotNull;
    }

    int size() {
        int countResumeInStorage = 0;
        for (Resume resumeFromStorage : storage) {
            if (resumeFromStorage != null) {
                countResumeInStorage++;
            }
        }
        return countResumeInStorage;
    }
}
