#include <algorithm>
#include <iostream>
#include <vector>

using std::cout;
using std::endl;

int main() {
	int task_num;
	std::cin >> task_num;
	std::vector<std::pair<int, int>> tasks(task_num);
	for (auto &[duration, deadline] : tasks) { std::cin >> duration >> deadline; }

	std::sort(tasks.begin(), tasks.end());

	long long time = 0;
	long long reward = 0;
	for (const auto &[duration, deadline] : tasks) {
		time += duration;
		reward += deadline - time;
	}

	cout << reward << endl;
}